import json
from typing import List, Dict, Type, TypeVar, Generic
from typing import get_type_hints

T = TypeVar('T')


class Libro:
    def __init__(self, cod_libro: int, titulo: str, precio: float):
        self.cod_libro = cod_libro
        self.titulo = titulo
        self.precio = precio

    def __str__(self):
        return self.titulo


class Cliente:
    def __init__(self, cod_cliente: int, nombre: str):
        self.cod_cliente = cod_cliente
        self.nombre = nombre

    def __str__(self):
        return self.nombre


class Prestamo:
    def __init__(self, cod_cliente: int, cod_libro: int, cantidad: int):
        self.cod_cliente = cod_cliente
        self.cod_libro = cod_libro
        self.cantidad = cantidad


class GestorBiblioteca:
    def __init__(self):
        pass

    def _leer(self, archivo: str, tipo: Type[T]) -> List[T]:
        try:
            with open(archivo, 'r', encoding='utf-8') as f:
                lista_dict = json.load(f)
                if tipo == Libro:
                    return [Libro(item['cod_libro'], item['titulo'], item['precio']) for item in lista_dict]
                elif tipo == Cliente:
                    return [Cliente(item['cod_cliente'], item['nombre']) for item in lista_dict]
                elif tipo == Prestamo:
                    return [Prestamo(item['cod_cliente'], item['cod_libro'], item['cantidad']) for item in lista_dict]
                return []
        except (FileNotFoundError, json.JSONDecodeError, KeyError):
            return []

    def _guardar(self, archivo: str, lista: List):
        with open(archivo, 'w', encoding='utf-8') as f:
            if lista and isinstance(lista[0], Libro):
                lista_dict = [{'cod_libro': l.cod_libro, 'titulo': l.titulo, 'precio': l.precio} for l in lista]
            elif lista and isinstance(lista[0], Cliente):
                lista_dict = [{'cod_cliente': c.cod_cliente, 'nombre': c.nombre} for c in lista]
            elif lista and isinstance(lista[0], Prestamo):
                lista_dict = [{'cod_cliente': p.cod_cliente, 'cod_libro': p.cod_libro, 'cantidad': p.cantidad} for p in
                              lista]
            else:
                lista_dict = []
            json.dump(lista_dict, f, indent=2)

    def inicializar_datos(self):
        self._guardar("libros.json", [Libro(1, "Java", 100), Libro(2, "UML", 50)])
        self._guardar("clientes.json", [Cliente(1, "Pedro"), Cliente(2, "Maria")])
        self._guardar("prestamos.json", [Prestamo(1, 1, 2), Prestamo(2, 1, 1)])

    def listar_libros_rango(self, x: float, y: float):
        libros = self._leer("libros.json", Libro)
        for libro in libros:
            if x <= libro.precio <= y:
                print(libro)

    def ingreso_total_libro(self, cod_libro: int):
        libros = self._leer("libros.json", Libro)
        prestamos = self._leer("prestamos.json", Prestamo)

        precio = 0.0
        for libro in libros:
            if libro.cod_libro == cod_libro:
                precio = libro.precio
                break

        cantidad_total = 0
        for prestamo in prestamos:
            if prestamo.cod_libro == cod_libro:
                cantidad_total += prestamo.cantidad

        print(f"Ingreso Total: {precio * cantidad_total}")

    def cliente_mas_prestamos(self):
        prestamos = self._leer("prestamos.json", Prestamo)
        clientes = self._leer("clientes.json", Cliente)

        conteo = {}
        for prestamo in prestamos:
            if prestamo.cod_cliente not in conteo:
                conteo[prestamo.cod_cliente] = 0
            conteo[prestamo.cod_cliente] += prestamo.cantidad

        if conteo:
            max_cliente = max(conteo.items(), key=lambda x: x[1])
            cliente_id = max_cliente[0]
            cliente_nombre = ""
            for cliente in clientes:
                if cliente.cod_cliente == cliente_id:
                    cliente_nombre = cliente.nombre
                    break
            print(f"Cliente con más préstamos: {cliente_nombre}")


def main():
    gb = GestorBiblioteca()
    gb.inicializar_datos()
    gb.ingreso_total_libro(1)
    gb.cliente_mas_prestamos()


if __name__ == "__main__":
    main()