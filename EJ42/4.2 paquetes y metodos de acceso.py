class Inmuebles:
    def __init__(self, identificadorInmobiliario: int, area: int, direccion: str):
        self.identificadorInmobiliario = identificadorInmobiliario
        self.area = area
        self.direccion = direccion
        self.precioVenta = 0.0

    def calcularPrecioVenta(self, valorArea: float) -> float:
        self.precioVenta = self.area * valorArea
        return self.precioVenta

    def imprimir(self):
        print(f"Identificador inmobiliario = {self.identificadorInmobiliario}")
        print(f"Área = {self.area}")
        print(f"Dirección = {self.direccion}")
        print(f"Precio de venta = ${self.precioVenta}")


class InmuebleVivienda(Inmuebles):
    def __init__(self, identificadorInmobiliario: int, area: int, direccion: str,
                 numeroHabitaciones: int, numeroBanos: int):
        super().__init__(identificadorInmobiliario, area, direccion)
        self.numeroHabitaciones = numeroHabitaciones
        self.numeroBanos = numeroBanos

    def imprimir(self):
        super().imprimir()
        print(f"Número de habitaciones = {self.numeroHabitaciones}")
        print(f"Número de baños = {self.numeroBanos}")


class Apartamento(InmuebleVivienda):
    def __init__(self, identificadorInmobiliario: int, area: int, direccion: str,
                 numeroHabitaciones: int, numeroBanos: int):
        super().__init__(identificadorInmobiliario, area, direccion,
                         numeroHabitaciones, numeroBanos)

    def imprimir(self):
        super().imprimir()


class Apartaestudio(Apartamento):
    valorArea = 1500000.0

    def __init__(self, identificadorInmobiliario: int, area: int, direccion: str,
                 numeroHabitaciones: int, numeroBanos: int):
        super().__init__(identificadorInmobiliario, area, direccion, 1, 1)

    def imprimir(self):
        super().imprimir()
        print()


class ApartamentoFamiliar(Apartamento):
    valorArea = 2000000.0

    def __init__(self, identificadorInmobiliario: int, area: int, direccion: str,
                 numeroHabitaciones: int, numeroBanos: int, valorAdministracion: int):
        super().__init__(identificadorInmobiliario, area, direccion,
                         numeroHabitaciones, numeroBanos)
        self.valorAdministracion = valorAdministracion

    def imprimir(self):
        super().imprimir()
        print(f"Valor de la administración = ${self.valorAdministracion}")
        print()


class Casa(InmuebleVivienda):
    def __init__(self, identificadorInmobiliario: int, area: int, direccion: str,
                 numeroHabitaciones: int, numeroBanos: int, numeroPisos: int):
        super().__init__(identificadorInmobiliario, area, direccion,
                         numeroHabitaciones, numeroBanos)
        self.numeroPisos = numeroPisos

    def imprimir(self):
        super().imprimir()
        print(f"Número de pisos = {self.numeroPisos}")


class CasaUrbana(Casa):
    def __init__(self, identificadorInmobiliario: int, area: int, direccion: str,
                 numeroHabitaciones: int, numeroBanos: int, numeroPisos: int):
        super().__init__(identificadorInmobiliario, area, direccion,
                         numeroHabitaciones, numeroBanos, numeroPisos)

    def imprimir(self):
        super().imprimir()


class CasaConjuntoCerrado(CasaUrbana):
    valorArea = 2500000.0

    def __init__(self, identificadorInmobiliario: int, area: int, direccion: str,
                 numeroHabitaciones: int, numeroBanos: int, numeroPisos: int,
                 valorAdministracion: int, tienePiscina: bool, tieneCamposDeportivos: bool):
        super().__init__(identificadorInmobiliario, area, direccion,
                         numeroHabitaciones, numeroBanos, numeroPisos)
        self.valorAdministracion = valorAdministracion
        self.tienePiscina = tienePiscina
        self.tieneCamposDeportivos = tieneCamposDeportivos

    def imprimir(self):
        super().imprimir()
        print(f"Valor de la administración = {self.valorAdministracion}")
        print(f"Tiene piscina? = {self.tienePiscina}")
        print(f"Tiene campos deportivos? = {self.tieneCamposDeportivos}")
        print()


class CasaIndependiente(CasaUrbana):
    valorArea = 3000000.0

    def __init__(self, identificadorInmobiliario: int, area: int, direccion: str,
                 numeroHabitaciones: int, numeroBanos: int, numeroPisos: int):
        super().__init__(identificadorInmobiliario, area, direccion,
                         numeroHabitaciones, numeroBanos, numeroPisos)

    def imprimir(self):
        super().imprimir()
        print()


class CasaRural(Casa):
    valorArea = 1500000.0

    def __init__(self, identificadorInmobiliario: int, area: int, direccion: str,
                 numeroHabitaciones: int, numeroBanos: int, numeroPisos: int,
                 distanciaCabera: int, altitud: int):
        super().__init__(identificadorInmobiliario, area, direccion,
                         numeroHabitaciones, numeroBanos, numeroPisos)
        self.distanciaCabera = distanciaCabera
        self.altitud = altitud

    def imprimir(self):
        super().imprimir()
        print(f"Distancia la cabecera municipal = {self.numeroHabitaciones}km.")
        print(f"Altitud sobre el nivel del mar = {self.altitud} metros.")
        print()


from enum import Enum
class TipoLocal(Enum):
    INTERNO = 1
    CALLE = 2

class Local(Inmuebles):
    def __init__(self, identificadorInmobiliario: int, area: int, direccion: str,
                 tipoLocal: TipoLocal):
        super().__init__(identificadorInmobiliario, area, direccion)
        self.tipoLocal = tipoLocal

    def imprimir(self):
        super().imprimir()
        print(f"Tipo de local = {self.tipoLocal.name}")


class LocalComercial(Local):
    valorArea = 3000000.0

    def __init__(self, identificadorInmobiliario: int, area: int, direccion: str,
                 tipoLocal: TipoLocal, centroComercial: str):
        super().__init__(identificadorInmobiliario, area, direccion, tipoLocal)
        self.centroComercial = centroComercial

    def imprimir(self):
        super().imprimir()
        print(f"Centro comercial = {self.centroComercial}")
        print()


class Oficina(Local):
    valorArea = 3500000.0

    def __init__(self, identificadorInmobiliario: int, area: int, direccion: str,
                 tipoLocal: TipoLocal, esGobierno: bool):
        super().__init__(identificadorInmobiliario, area, direccion, tipoLocal)
        self.esGobierno = esGobierno

    def imprimir(self):
        super().imprimir()
        print(f"Es oficina gubernamental = {self.esGobierno}")
        print()


def main():
    apto1 = ApartamentoFamiliar(
        identificadorInmobiliario=103067,
        area=120,
        direccion="Avenida Santander 45-45",
        numeroHabitaciones=3,
        numeroBanos=2,
        valorAdministracion=200000
    )
    print("Datos apartamento")
    apto1.calcularPrecioVenta(apto1.valorArea)
    apto1.imprimir()

    print("Datos apartamento")
    aptestudio1 = Apartaestudio(
        identificadorInmobiliario=12345,
        area=50,
        direccion="Avenida caracas 30-15",
        numeroHabitaciones=1,
        numeroBanos=2
    )
    aptestudio1.calcularPrecioVenta(aptestudio1.valorArea)
    aptestudio1.imprimir()


if __name__ == "__main__":
    main()


