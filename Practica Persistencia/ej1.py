import json
import os
from typing import List


class Charango:
    def __init__(self, material: str, nro_cuerdas: int, cuerdas: List[bool]):
        self.material = material
        self.nro_cuerdas = nro_cuerdas
        self.cuerdas = cuerdas

    def __str__(self):
        return f"Charango{{material='{self.material}', nroCuerdas={self.nro_cuerdas}, cuerdas={self.cuerdas}}}"


class ArchivoCharango:
    def __init__(self, ruta: str = "charangos.json"):
        self.ruta = ruta

    def guardar_lista(self, lista: List[Charango]):
        try:
            with open(self.ruta, 'w', encoding='utf-8') as f:
                lista_dict = [
                    {
                        'material': c.material,
                        'nroCuerdas': c.nro_cuerdas,
                        'cuerdas': c.cuerdas
                    }
                    for c in lista
                ]
                json.dump(lista_dict, f, indent=2)
        except IOError as e:
            print(f"Error al guardar: {e}")

    def leer_lista(self) -> List[Charango]:
        try:
            if not os.path.exists(self.ruta):
                return []

            with open(self.ruta, 'r', encoding='utf-8') as f:
                lista_dict = json.load(f)
                return [
                    Charango(
                        material=item['material'],
                        nro_cuerdas=item['nroCuerdas'],
                        cuerdas=item['cuerdas']
                    )
                    for item in lista_dict
                ]
        except FileNotFoundError:
            return []
        except (IOError, json.JSONDecodeError) as e:
            print(f"Error al leer: {e}")
            return []

    def guardar_charango(self, charango: Charango):
        lista = self.leer_lista()
        lista.append(charango)
        self.guardar_lista(lista)

    def eliminar_cuerdas_daniadas(self):
        lista = self.leer_lista()
        lista_filtrada = [
            c for c in lista
            if sum(1 for cuerda in c.cuerdas if not cuerda) <= 6
        ]
        self.guardar_lista(lista_filtrada)

    def listar_por_material(self, material: str):
        lista = self.leer_lista()
        for charango in lista:
            if charango.material.lower() == material.lower():
                print(charango)

    def buscar_diez_cuerdas(self):
        lista = self.leer_lista()
        for charango in lista:
            if charango.nro_cuerdas == 10:
                print(charango)

    def ordenar_por_material(self):
        lista = self.leer_lista()
        lista.sort(key=lambda x: x.material)
        self.guardar_lista(lista)
        for charango in lista:
            print(charango)


def main():
    arch = ArchivoCharango()

    cuerdas1 = [True, True, False, True, False, False, False, False, False, False]
    cuerdas2 = [True, True, True, True, True, True, True, True, True, True]

    arch.guardar_charango(Charango("Madera", 10, cuerdas1))
    arch.guardar_charango(Charango("Armadillo", 10, cuerdas2))
    arch.guardar_charango(Charango("Madera", 8, cuerdas2))

    print("--- Ordenado ---")
    arch.ordenar_por_material()

    print("\n--- Eliminar Dañados ---")
    arch.eliminar_cuerdas_daniadas()
    arch.listar_por_material("Madera")


if __name__ == "__main__":
    main()