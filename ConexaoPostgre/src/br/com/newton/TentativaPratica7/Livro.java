package br.com.newton.TentativaPratica7;


    public class Livro {
        private String id;
        private String titulo;
        private String autor;
        private double preco;

        public Livro() {
        }

        public Livro(String titulo, String autor, double preco) {
            this.titulo = titulo;
            this.autor = autor;
            this.preco = preco;
        }
        public String getId() {
            return id;
        }
        public void setId(String id) {
            this.id = id;
        }
        public String getTitulo() {
            return titulo;
        }
        public void setTitulo(String titulo) {
            this.titulo = titulo;
        }
        public String getAutor() {
            return autor;
        }
        public void setAutor(String autor) {
            this.autor = autor;
        }
        public double getPreco() {
            return preco;
        }
        public void setPreco(double preco) {
            this.preco = preco;
        }
    }

