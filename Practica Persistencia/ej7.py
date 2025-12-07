import json
from typing import List


class Persona:
    def __init__(self, nombre: str, ci: int):
        self.nombre = nombre
        self.ci = ci


class Niño(Persona):
    def __init__(self, nombre: str, ci: int, edad: int, peso: float, talla: float):
        super().__init__(nombre, ci)
        self.edad = edad
        self.peso = peso
        self.talla = talla

    def es_peso_adecuado(self):
        peso_ideal = (self.talla * 100) - 100
        return abs(self.peso - peso_ideal) < 5

    def __str__(self):
        return f"{self.nombre} Edad:{self.edad}"


class ArchNiño:
    def __init__(self, nombre_archivo: str = "niños.json"):
        self.nombre_archivo = nombre_archivo

    def guardar(self, niño: Niño):
        lista = self.listar()
        lista.append(niño)
        with open(self.nombre_archivo, 'w', encoding='utf-8') as f:
            lista_dict = [
                {
                    'nombre': n.nombre,
                    'ci': n.ci,
                    'edad': n.edad,
                    'peso': n.peso,
                    'talla': n.talla
                }
                for n in lista
            ]
            json.dump(lista_dict, f, indent=2)

    def listar(self) -> List[Niño]:
        try:
            with open(self.nombre_archivo, 'r', encoding='utf-8') as f:
                lista_dict = json.load(f)
                return [
                    Niño(
                        nombre=item['nombre'],
                        ci=item['ci'],
                        edad=item['edad'],
                        peso=item['peso'],
                        talla=item['talla']
                    )
                    for item in lista_dict
                ]
        except (FileNotFoundError, json.JSONDecodeError, KeyError):
            return []

    def ninos_peso_adecuado(self):
        lista = self.listar()
        count = sum(1 for niño in lista if niño.es_peso_adecuado())
        print(f"Niños con peso adecuado: {count}")

    def promedio_edad(self):
        lista = self.listar()
        if lista:
            promedio = sum(niño.edad for niño in lista) / len(lista)
            print(f"Promedio edad: {promedio}")

    def buscar_carnet(self, ci: int):
        lista = self.listar()
        for niño in lista:
            if niño.ci == ci:
                print(niño)


def main():
    an = ArchNiño()
    an.guardar(Niño("Luis", 111, 10, 35, 1.40))
    an.ninos_peso_adecuado()
    an.promedio_edad()


if __name__ == "__main__":
    main()