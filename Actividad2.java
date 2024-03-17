public class Main {
    public static void main(String[] args) {
        // Definir un rectángulo (ancho = 4, alto = 3)
        Rectangulo rectangulo1 = new Rectangulo(4, 3);

        // Imprimir el área y el perímetro del rectángulo
        System.out.println("Área del rectángulo: " + rectangulo1.obtenerArea());
        System.out.println("Perímetro del rectángulo: " + rectangulo1.obtenerPerimetro());

        // Cambiar el tamaño del rectángulo por un factor de 3
        rectangulo1.redimensionar(3);

        // Volver a imprimir el área y el perímetro del rectángulo
        System.out.println("Área del rectángulo después de redimensionar: " + rectangulo1.obtenerArea());
        System.out.println("Perímetro del rectángulo después de redimensionar: " + rectangulo1.obtenerPerimetro());
    }

    interface Redimensionable {
        void redimensionar(double factor);
    }

    abstract static class Figura {
        protected int numeroLados;

        public Figura(int numeroLados) {
            this.numeroLados = numeroLados;
        }

        public int obtenerNumeroLados() {
            return numeroLados;
        }

        public abstract double obtenerArea();
        public abstract double obtenerPerimetro();
    }

    static class Rectangulo extends Figura implements Redimensionable {
        private double anchura;
        private double altura;

        public Rectangulo(double anchura, double altura) {
            super(4); 
            this.anchura = anchura;
            this.altura = altura;
        }

        @Override
        public double obtenerArea() {
            return anchura * altura;
        }

        @Override
        public double obtenerPerimetro() {
            return 2 * (anchura + altura);
        }

        @Override
        public void redimensionar(double factor) {
            anchura *= factor;
            altura *= factor;
        }
    }

    static class Triangulo extends Figura implements Redimensionable {
        private double base;
        private double altura;

        public Triangulo(double base, double altura) {
            super(3); 
            this.base = base;
            this.altura = altura;
        }

        @Override
        public double obtenerArea() {
            return 0.5 * base * altura;
        }

        @Override
        public double obtenerPerimetro() {
            throw new UnsupportedOperationException("No se puede calcular el perímetro de un triángulo genérico.");
        }

        @Override
        public void redimensionar(double factor) {
            base *= factor;
            altura *= factor;
        }
    }
}
