import json
from typing import List


class Estudiante:
    def __init__(self, ru: int, nombre: str, paterno: str, materno: str, edad: int):
        self.ru = ru
        self.nombre = nombre
        self.paterno = paterno
        self.materno = materno
        self.edad = edad

    def __str__(self):
        return f"{self.nombre} {self.paterno}"


class Nota:
    def __init__(self, materia: str, nota_final: float, estudiante: Estudiante):
        self.materia = materia
        self.nota_final = nota_final
        self.estudiante = estudiante

    def __str__(self):
        return f"{self.estudiante} - {self.materia}: {self.nota_final}"


class ArchiNota:
    def __init__(self, nombre_archivo: str = "notas.json"):
        self.nombre_archivo = nombre_archivo

    def _leer(self) -> List[Nota]:
        try:
            with open(self.nombre_archivo, 'r', encoding='utf-8') as f:
                lista_dict = json.load(f)
                notas = []
                for item in lista_dict:
                    estudiante_dict = item['estudiante']
                    estudiante = Estudiante(
                        ru=estudiante_dict['ru'],
                        nombre=estudiante_dict['nombre'],
                        paterno=estudiante_dict['paterno'],
                        materno=estudiante_dict['materno'],
                        edad=estudiante_dict['edad']
                    )
                    nota = Nota(
                        materia=item['materia'],
                        nota_final=item['nota_final'],
                        estudiante=estudiante
                    )
                    notas.append(nota)
                return notas
        except (FileNotFoundError, json.JSONDecodeError, KeyError):
            return []

    def _guardar(self, lista: List[Nota]):
        lista_dict = []
        for nota in lista:
            estudiante_dict = {
                'ru': nota.estudiante.ru,
                'nombre': nota.estudiante.nombre,
                'paterno': nota.estudiante.paterno,
                'materno': nota.estudiante.materno,
                'edad': nota.estudiante.edad
            }
            nota_dict = {
                'materia': nota.materia,
                'nota_final': nota.nota_final,
                'estudiante': estudiante_dict
            }
            lista_dict.append(nota_dict)

        with open(self.nombre_archivo, 'w', encoding='utf-8') as f:
            json.dump(lista_dict, f, indent=2)

    def agregar_nota(self, nota: Nota):
        lista = self._leer()
        lista.append(nota)
        self._guardar(lista)

    def promedio_general(self):
        lista = self._leer()
        if not lista:
            print("Promedio General: 0.0")
            return
        promedio = sum(n.nota_final for n in lista) / len(lista)
        print(f"Promedio General: {promedio}")

    def mejor_estudiante(self):
        lista = self._leer()
        if lista:
            mejor = max(lista, key=lambda n: n.nota_final)
            print(f"Mejor: {mejor.estudiante}")

    def eliminar_materia(self, materia: str):
        lista = self._leer()
        nueva_lista = [n for n in lista if n.materia.lower() != materia.lower()]
        self._guardar(nueva_lista)


def main():
    an = ArchiNota()
    e1 = Estudiante(1, "Juan", "Perez", "A", 20)
    an.agregar_nota(Nota("Fisica", 90, e1))
    an.agregar_nota(Nota("Quimica", 50, e1))
    an.promedio_general()
    an.eliminar_materia("Quimica")


if __name__ == "__main__":
    main()