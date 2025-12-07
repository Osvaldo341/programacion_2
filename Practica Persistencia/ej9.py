import json
from typing import List


class Animal:
    def __init__(self, especie: str, nombre: str, cantidad: int):
        self.especie = especie
        self.nombre = nombre
        self.cantidad = cantidad

    def __str__(self):
        return self.nombre


class Zoologico:
    def __init__(self, id_zoo: int, nombre: str):
        self.id = id_zoo
        self.nombre = nombre
        self.animales = []

    def __str__(self):
        return f"{self.nombre} Animales: {len(self.animales)}"


class ArchZoo:
    def __init__(self, archivo: str = "zoos.json"):
        self.archivo = archivo

    def _leer(self) -> List[Zoologico]:
        try:
            with open(self.archivo, 'r', encoding='utf-8') as f:
                lista_dict = json.load(f)
                zoos = []
                for zoo_dict in lista_dict:
                    zoo = Zoologico(
                        id_zoo=zoo_dict['id'],
                        nombre=zoo_dict['nombre']
                    )
                    for animal_dict in zoo_dict['animales']:
                        animal = Animal(
                            especie=animal_dict['especie'],
                            nombre=animal_dict['nombre'],
                            cantidad=animal_dict['cantidad']
                        )
                        zoo.animales.append(animal)
                    zoos.append(zoo)
                return zoos
        except (FileNotFoundError, json.JSONDecodeError, KeyError):
            return []

    def _guardar(self, lista: List[Zoologico]):
        lista_dict = []
        for zoo in lista:
            zoo_dict = {
                'id': zoo.id,
                'nombre': zoo.nombre,
                'animales': [
                    {
                        'especie': animal.especie,
                        'nombre': animal.nombre,
                        'cantidad': animal.cantidad
                    }
                    for animal in zoo.animales
                ]
            }
            lista_dict.append(zoo_dict)

        with open(self.archivo, 'w', encoding='utf-8') as f:
            json.dump(lista_dict, f, indent=2)

    def agregar_zoo(self, zoo: Zoologico):
        lista = self._leer()
        lista.append(zoo)
        self._guardar(lista)

    def listar_mayor_variedad(self):
        lista = self._leer()
        if lista:
            mayor = max(lista, key=lambda z: len(z.animales))
            print(f"Mayor variedad: {mayor.nombre}")

    def eliminar_vacios(self):
        lista = self._leer()
        nueva_lista = [zoo for zoo in lista if zoo.animales]
        self._guardar(nueva_lista)

    def mostrar_especie(self, especie: str):
        lista = self._leer()
        for zoo in lista:
            for animal in zoo.animales:
                if animal.especie.lower() == especie.lower():
                    print(f"{animal.nombre} en {zoo.nombre}")


def main():
    az = ArchZoo()
    z1 = Zoologico(1, "Panda")
    z1.animales.append(Animal("Mamifero", "Oso", 2))
    az.agregar_zoo(z1)
    az.listar_mayor_variedad()


if __name__ == "__main__":
    main()