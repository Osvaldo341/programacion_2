import json
import os
from typing import List, Optional


class Producto:
    def __init__(self, codigo: int, nombre: str, precio: float):
        self.codigo = codigo
        self.nombre = nombre
        self.precio = precio

    def __str__(self):
        return f"Producto{{codigo={self.codigo}, nombre='{self.nombre}', precio={self.precio}}}"


class ArchivoProducto:
    def __init__(self, nombre: str):
        self.nombre_archivo = nombre

    def crear_archivo(self):
        with open(self.nombre_archivo, 'w', encoding='utf-8') as f:
            json.dump([], f)

    def _leer(self) -> List[Producto]:
        try:
            with open(self.nombre_archivo, 'r', encoding='utf-8') as f:
                lista_dict = json.load(f)
                return [
                    Producto(
                        codigo=item['codigo'],
                        nombre=item['nombre'],
                        precio=item['precio']
                    )
                    for item in lista_dict
                ]
        except (FileNotFoundError, json.JSONDecodeError):
            return []

    def guarda_producto(self, p: Producto):
        lista = self._leer()
        lista.append(p)
        with open(self.nombre_archivo, 'w', encoding='utf-8') as f:
            lista_dict = [
                {
                    'codigo': producto.codigo,
                    'nombre': producto.nombre,
                    'precio': producto.precio
                }
                for producto in lista
            ]
            json.dump(lista_dict, f, indent=2)

    def busca_producto(self, codigo: int) -> Optional[Producto]:
        lista = self._leer()
        for producto in lista:
            if producto.codigo == codigo:
                return producto
        return None

    def promedio_precios(self):
        lista = self._leer()
        if not lista:
            print("Promedio: 0.0")
            return
        promedio = sum(p.precio for p in lista) / len(lista)
        print(f"Promedio: {promedio}")

    def producto_mas_caro(self):
        lista = self._leer()
        if lista:
            mas_caro = max(lista, key=lambda p: p.precio)
            print(mas_caro)


def main():
    ap = ArchivoProducto("productos.json")
    ap.crear_archivo()
    ap.guarda_producto(Producto(1, "Coca Cola", 10.5))
    ap.guarda_producto(Producto(2, "Pepsi", 9.5))
    print(ap.busca_producto(1))
    ap.promedio_precios()


if __name__ == "__main__":
    main()