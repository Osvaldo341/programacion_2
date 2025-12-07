import json
from datetime import datetime
from typing import List


class Alimento:
    def __init__(self, nombre: str, fecha_vencimiento: str, cantidad: int):
        self.nombre = nombre
        self.fecha_vencimiento = fecha_vencimiento
        self.cantidad = cantidad

    def esta_vencido(self, fecha_comparacion: str):
        fecha_venc = datetime.strptime(self.fecha_vencimiento, "%Y-%m-%d")
        fecha_comp = datetime.strptime(fecha_comparacion, "%Y-%m-%d")
        return fecha_venc < fecha_comp

    def __str__(self):
        return f"{self.nombre} cant:{self.cantidad}"


class ArchRefri:
    def __init__(self, archivo: str = "refri.json"):
        self.archivo = archivo

    def _leer(self) -> List[Alimento]:
        try:
            with open(self.archivo, 'r', encoding='utf-8') as f:
                lista_dict = json.load(f)
                return [
                    Alimento(
                        nombre=item['nombre'],
                        fecha_vencimiento=item['fecha_vencimiento'],
                        cantidad=item['cantidad']
                    )
                    for item in lista_dict
                ]
        except (FileNotFoundError, json.JSONDecodeError, KeyError):
            return []

    def _guardar(self, lista: List[Alimento]):
        with open(self.archivo, 'w', encoding='utf-8') as f:
            lista_dict = [
                {
                    'nombre': a.nombre,
                    'fecha_vencimiento': a.fecha_vencimiento,
                    'cantidad': a.cantidad
                }
                for a in lista
            ]
            json.dump(lista_dict, f, indent=2)

    def agregar(self, alimento: Alimento):
        lista = self._leer()
        lista.append(alimento)
        self._guardar(lista)

    def eliminar_cantidad_cero(self):
        lista = self._leer()
        nueva_lista = [a for a in lista if a.cantidad != 0]
        self._guardar(nueva_lista)

    def mostrar_caducados(self, fecha_actual: str):
        lista = self._leer()
        for alimento in lista:
            if alimento.esta_vencido(fecha_actual):
                print(alimento)

    def max_cantidad(self):
        lista = self._leer()
        if lista:
            max_alimento = max(lista, key=lambda a: a.cantidad)
            print(max_alimento)


def main():
    ar = ArchRefri()
    ar.agregar(Alimento("Leche", "2025-01-01", 2))
    ar.agregar(Alimento("Jugo de Naranja", "2025-04-12", 1))

    print("Caducados al 2025-02-01:")
    ar.mostrar_caducados("2025-02-01")
    ar.eliminar_cantidad_cero()


if __name__ == "__main__":
    main()