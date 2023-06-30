class Car:
    "This a class for car"
    def __init__(self, manufacturer, model, make, transmission, color):
        self.manufacturer = manufacturer
        self.model = model
        self.make = make
        self.transmission = transmission
        self.color = color
    def accelerate(self):
        print("{} {} is moving".format(self.manufacturer, self.model))
    def stop(self):
        print("{} {} has stopped".format(self.manufacturer, self.model))

BMW = Car("BMW", "BMW1", "2013", "Manual", "Red")
Audi = Car("Audi", "Audi1", "2015", "Automatic", "Blue")
Honda = Car("Honda", "Honda1", "2018", "Automatic", "Emerald")

BMW.accelerate()
Audi.accelerate()
Honda.accelerate()
Honda.stop()