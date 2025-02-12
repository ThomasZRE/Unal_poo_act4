import tkinter as tk
from tkinter import messagebox
import numpy as np

class NotasApp:
    def __init__(self, root):
        self.root = root
        self.root.title("Notas")
        self.root.geometry("300x350")
        
        self.labels = []
        self.entries = []
        
        for i in range(5):
            label = tk.Label(root, text=f"Nota {i+1}:")
            label.pack()
            entry = tk.Entry(root)
            entry.pack()
            self.labels.append(label)
            self.entries.append(entry)
        
        self.calcular_btn = tk.Button(root, text="Calcular", command=self.calcular)
        self.calcular_btn.pack()
        
        self.limpiar_btn = tk.Button(root, text="Limpiar", command=self.limpiar)
        self.limpiar_btn.pack()
        
        self.resultados = tk.Label(root, text="")
        self.resultados.pack()
    
    def calcular(self):
        try:
            notas = [float(entry.get()) for entry in self.entries]
            promedio = np.mean(notas)
            desviacion = np.std(notas, ddof=0)
            mayor = np.max(notas)
            menor = np.min(notas)
            
            resultado_texto = (f"Promedio: {promedio:.2f}\n"
                              f"Desviación estándar: {desviacion:.2f}\n"
                              f"Mayor nota: {mayor:.2f}\n"
                              f"Menor nota: {menor:.2f}")
            self.resultados.config(text=resultado_texto)
        except ValueError:
            messagebox.showerror("Error", "Por favor, ingrese valores numéricos válidos.")
    
    def limpiar(self):
        for entry in self.entries:
            entry.delete(0, tk.END)
        self.resultados.config(text="")

if __name__ == "__main__":
    root = tk.Tk()
    app = NotasApp(root)
    root.mainloop()

