import json
from typing import List


class Empresa:
    def __init__(self, nombre: str, rubro: str, nro_empleados: int):
        self.nombre = nombre
        self.rubro = rubro
        self.nro_empleados = nro_empleados

    def __str__(self):
        return f"{self.nombre} ({self.rubro}) - Empleados: {self.nro_empleados}"


class ArchivoEmpresa:
    def __init__(self, ruta: str = "empresas.txt"):
        self.ruta = ruta

    def _leer(self) -> List[Empresa]:
        try:
            with open(self.ruta, 'r', encoding='utf-8') as f:
                lista_dict = json.load(f)
                return [
                    Empresa(
                        nombre=item['nombre'],
                        rubro=item['rubro'],
                        nro_empleados=item['nro_empleados']
                    )
                    for item in lista_dict
                ]
        except (FileNotFoundError, json.JSONDecodeError, KeyError):
            return []

    def _guardar(self, lista: List[Empresa]):
        with open(self.ruta, 'w', encoding='utf-8') as f:
            lista_dict = [
                {
                    'nombre': e.nombre,
                    'rubro': e.rubro,
                    'nro_empleados': e.nro_empleados
                }
                for e in lista
            ]
            json.dump(lista_dict, f, indent=2)

    def guardar_empresa(self, empresa: Empresa):
        lista = self._leer()
        lista.append(empresa)
        self._guardar(lista)

    def mostrar_todas(self):
        lista = self._leer()
        for empresa in lista:
            print(empresa)

    def buscar_por_nombre(self, nombre: str):
        lista = self._leer()
        encontrada = False
        for empresa in lista:
            if empresa.nombre.lower() == nombre.lower():
                print(empresa)
                encontrada = True
                break
        if not encontrada:
            print("No encontrada")


def main():
    ae = ArchivoEmpresa()
    ae.guardar_empresa(Empresa("Venado", "Software", 150))
    ae.guardar_empresa(Empresa("Umsa", "Telecom", 200))

    print("--- Lista ---")
    ae.mostrar_todas()
    print("--- Buscar ---")
    ae.buscar_por_nombre("Umsa")


if __name__ == "__main__":
    main()