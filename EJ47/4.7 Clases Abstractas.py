from abc import ABC, abstractmethod


class Animal(ABC):
    def __init__(self):
        self.sonido = None
        self.alimentos = None
        self.habitat = None
        self.nombreCientifico = None

    @abstractmethod
    def getNombreCientifico(self):
        pass

    @abstractmethod
    def getSonido(self):
        pass

    @abstractmethod
    def getAlimentos(self):
        pass

    @abstractmethod
    def getHabitat(self):
        pass



class Canino(Animal):
    pass

class Felino(Animal):
    pass


class Gato(Felino):
    def getSonido(self):
        return "Maullido"

    def getAlimentos(self):
        return "Ratones"

    def getHabitat(self):
        return "Domestico"

    def getNombreCientifico(self):
        return "Felis silvestris catus"


class Leon(Felino):
    def getSonido(self):
        return "Rugido"

    def getAlimentos(self):
        return "Carnivoro"

    def getHabitat(self):
        return "Praderas"

    def getNombreCientifico(self):
        return "Panthera leo"


class Lobo(Canino):
    def getSonido(self):
        return "Aullido"

    def getAlimentos(self):
        return "Carnivoro"

    def getHabitat(self):
        return "Bosque"

    def getNombreCientifico(self):
        return "Canis lupus"


class Perro(Canino):
    def getSonido(self):
        return "Ladrido"

    def getAlimentos(self):
        return "Carnivoro"

    def getHabitat(self):
        return "Domestico"

    def getNombreCientifico(self):
        return "Canis lupus familiaris"


def main():
    animales = [Gato(), Perro(), Lobo(), Leon()]

    for animal in animales:
        print(animal.getNombreCientifico())
        print("Sonido:", animal.getSonido())
        print("Alimentos:", animal.getAlimentos())
        print("Habitat:", animal.getHabitat())
        print()


if __name__ == "__main__":
    main()
