import json
from typing import List


class Medicamento:
    def __init__(self, nombre: str, cod_medicamento: int, tipo: str, precio: float):
        self.nombre = nombre
        self.cod_medicamento = cod_medicamento
        self.tipo = tipo
        self.precio = precio

    def __str__(self):
        return f"{self.nombre} ({self.tipo})"


class Farmacia:
    def __init__(self, nombre_farmacia: str, sucursal: int, direccion: str):
        self.nombre_farmacia = nombre_farmacia
        self.sucursal = sucursal
        self.direccion = direccion
        self.medicamentos = []

    def add_medicamento(self, medicamento: Medicamento):
        self.medicamentos.append(medicamento)

    def __str__(self):
        return f"{self.nombre_farmacia} Suc:{self.sucursal}"


class ArchFarmacia:
    def __init__(self, nombre_archivo: str):
        self.nombre_archivo = nombre_archivo

    def _leer(self) -> List[Farmacia]:
        try:
            with open(self.nombre_archivo, 'r', encoding='utf-8') as f:
                lista_dict = json.load(f)
                farmacias = []
                for farm_dict in lista_dict:
                    farmacia = Farmacia(
                        nombre_farmacia=farm_dict['nombre_farmacia'],
                        sucursal=farm_dict['sucursal'],
                        direccion=farm_dict['direccion']
                    )
                    for med_dict in farm_dict['medicamentos']:
                        medicamento = Medicamento(
                            nombre=med_dict['nombre'],
                            cod_medicamento=med_dict['cod_medicamento'],
                            tipo=med_dict['tipo'],
                            precio=med_dict['precio']
                        )
                        farmacia.add_medicamento(medicamento)
                    farmacias.append(farmacia)
                return farmacias
        except (FileNotFoundError, json.JSONDecodeError, KeyError):
            return []

    def _guardar(self, lista: List[Farmacia]):
        lista_dict = []
        for farmacia in lista:
            farm_dict = {
                'nombre_farmacia': farmacia.nombre_farmacia,
                'sucursal': farmacia.sucursal,
                'direccion': farmacia.direccion,
                'medicamentos': [
                    {
                        'nombre': med.nombre,
                        'cod_medicamento': med.cod_medicamento,
                        'tipo': med.tipo,
                        'precio': med.precio
                    }
                    for med in farmacia.medicamentos
                ]
            }
            lista_dict.append(farm_dict)

        with open(self.nombre_archivo, 'w', encoding='utf-8') as f:
            json.dump(lista_dict, f, indent=2)

    def adicionar(self, farmacia: Farmacia):
        lista = self._leer()
        lista.append(farmacia)
        self._guardar(lista)

    def mostrar_meds_tos(self, sucursal: int):
        lista = self._leer()
        for farmacia in lista:
            if farmacia.sucursal == sucursal:
                for medicamento in farmacia.medicamentos:
                    if medicamento.tipo.lower() == "tos":
                        print(medicamento)

    def mostrar_sucursal_tapsin(self):
        lista = self._leer()
        for farmacia in lista:
            for medicamento in farmacia.medicamentos:
                if medicamento.nombre.lower() == "tapsin":
                    print(f"Suc: {farmacia.sucursal} Dir: {farmacia.direccion}")
                    break

    def ordenar_direccion(self):
        lista = self._leer()
        lista.sort(key=lambda f: f.direccion)
        self._guardar(lista)


def main():
    af = ArchFarmacia("farmacias.json")
    f1 = Farmacia("Farmacorp", 1, "Av. Arce")
    f1.add_medicamento(Medicamento("Tapsin", 101, "Resfrio", 5.5))
    f1.add_medicamento(Medicamento("Jarabe", 102, "Tos", 20.0))
    af.adicionar(f1)
    af.mostrar_sucursal_tapsin()


if __name__ == "__main__":
    main()