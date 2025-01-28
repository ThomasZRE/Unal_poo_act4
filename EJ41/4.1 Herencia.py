class Cuenta:
    def __init__(self, saldo: float, tasa_anual: float):
        self.saldo = saldo
        self.numero_consignaciones = 0
        self.numero_retiros = 0
        self.tasa_anual = tasa_anual
        self.comision_mensual = 0

    def consignar(self, cantidad: float):
        self.saldo += cantidad
        self.numero_consignaciones += 1

    def retirar(self, cantidad: float):
        nuevo_saldo = self.saldo - cantidad
        if nuevo_saldo >= 0:
            self.saldo = nuevo_saldo
            self.numero_retiros += 1
        else:
            print("La cantidad a retirar excede el saldo actual")

    def calcular_interes(self):
        tasa_mensual = self.tasa_anual / 12
        interes_mensual = self.saldo * tasa_mensual
        self.saldo += interes_mensual

    def extracto_mensual(self):
        self.saldo -= self.comision_mensual
        self.calcular_interes()


class CuentaAhorros(Cuenta):
    def __init__(self, saldo: float, tasa: float):
        super().__init__(saldo, tasa)
        self.activa = self.saldo >= 10000

    def retirar(self, cantidad: float):
        if self.activa:
            super().retirar(cantidad)

    def consignar(self, cantidad: float):
        if self.activa:
            super().consignar(cantidad)

    def extracto_mensual(self):
        if self.numero_retiros > 4:
            self.comision_mensual += (self.numero_retiros - 4) * 1000
        super().extracto_mensual()
        if self.saldo < 10000:
            self.activa = False

    def imprimir(self):
        print("Saldo = $", self.saldo)
        print("Comisión mensual = $", self.comision_mensual)
        print("Número de transacciones =", self.numero_consignaciones + self.numero_retiros)
        print()


class CuentaCorriente(Cuenta):
    def __init__(self, saldo: float, tasa: float):
        super().__init__(saldo, tasa)
        self.sobregiro = 0

    def retirar(self, cantidad: float):
        resultado = self.saldo - cantidad
        if resultado < 0:
            self.sobregiro -= resultado
            self.saldo = 0
        else:
            super().retirar(cantidad)

    def consignar(self, cantidad: float):
        if self.sobregiro > 0:
            residuo = self.sobregiro - cantidad
            if residuo > 0:
                self.sobregiro = residuo
                self.saldo = 0
            else:
                self.sobregiro = -residuo
                self.saldo = 0
        else:
            super().consignar(cantidad)

    def extracto_mensual(self):
        super().extracto_mensual()

    def imprimir(self):
        print("Saldo = $", self.saldo)
        print("Cargo mensual = $", self.comision_mensual)
        print("Número de transacciones =", self.numero_consignaciones + self.numero_retiros)
        print("Valor de sobregiro = $", (self.numero_consignaciones + self.numero_retiros))
        print()


        


def main():
    print("Cuenta de ahorros")
    saldo_inicial_ahorros = float(input("Ingrese saldo inicial= $"))
    tasa_ahorros = float(input("Ingrese tasa de interés= "))
    cuenta1 = CuentaAhorros(saldo_inicial_ahorros, tasa_ahorros)
    cantidad_depositar = float(input("Ingresar cantidad a consignar: $"))
    cuenta1.consignar(cantidad_depositar)
    cantidad_retirar = float(input("Ingresar cantidad a retirar: $"))
    cuenta1.retirar(cantidad_retirar)
    cuenta1.extracto_mensual()
    cuenta1.imprimir()


if __name__ == "__main__":
    main()

