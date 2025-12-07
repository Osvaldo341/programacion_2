import json
import os
from typing import List


class Trabajador:
    def __init__(self, nombre: str, carnet: int, salario: float):
        self.nombre = nombre
        self.carnet = carnet
        self.salario = salario

    def __str__(self):
        return f"Trabajador{{nombre='{self.nombre}', carnet={self.carnet}, salario={self.salario}}}"


class ArchivoTrabajador:
    def __init__(self, nombre_arch: str):
        self.nombre_arch = nombre_arch

    def crear_archivo(self):
        with open(self.nombre_arch, 'w', encoding='utf-8') as f:
            json.dump([], f)

    def _leer_todos(self) -> List[Trabajador]:
        try:
            with open(self.nombre_arch, 'r', encoding='utf-8') as f:
                lista_dict = json.load(f)
                return [
                    Trabajador(
                        nombre=item['nombre'],
                        carnet=item['carnet'],
                        salario=item['salario']
                    )
                    for item in lista_dict
                ]
        except (FileNotFoundError, json.JSONDecodeError):
            return []

    def _guardar_todos(self, lista: List[Trabajador]):
        with open(self.nombre_arch, 'w', encoding='utf-8') as f:
            lista_dict = [
                {
                    'nombre': t.nombre,
                    'carnet': t.carnet,
                    'salario': t.salario
                }
                for t in lista
            ]
            json.dump(lista_dict, f, indent=2)

    def guardar_trabajador(self, t: Trabajador):
        lista = self._leer_todos()
        lista.append(t)
        self._guardar_todos(lista)

    def aumenta_salario(self, aumento: float, t: Trabajador):
        lista = self._leer_todos()
        for trabajador in lista:
            if trabajador.carnet == t.carnet:
                trabajador.salario += aumento
        self._guardar_todos(lista)

    def buscar_mayor_salario(self):
        lista = self._leer_todos()
        if lista:
            mayor = max(lista, key=lambda x: x.salario)
            print(mayor)

    def ordenar_por_salario(self):
        lista = self._leer_todos()
        lista.sort(key=lambda x: x.salario)
        self._guardar_todos(lista)
        for trabajador in lista:
            print(trabajador)


def main():
    arch = ArchivoTrabajador("trabajadores.json")
    arch.crear_archivo()

    t1 = Trabajador("Juan", 123, 2000)
    arch.guardar_trabajador(t1)
    arch.guardar_trabajador(Trabajador("Ana", 456, 3500))

    arch.aumenta_salario(500, t1)

    print("Mayor salario:")
    arch.buscar_mayor_salario()


if __name__ == "__main__":
    main()