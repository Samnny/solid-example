package com.solid.srp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Course {

    private String nome;
    private String categoria;
    private String descricao;

    private Connection getConnection() {
        String url = "jdbc:mysql://localhost:3306/exemplo";
        String user = "seu_usuario";
        String password = "sua_senha";

        try {
            return DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Falha ao conectar ao banco de dados.");
            return null;
        }
    }

    public void criaCategoria() {
        String sql = "INSERT INTO categorias (nome) VALUES (?)";

        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, this.categoria);
            int rowsInserted = statement.executeUpdate();

            if (rowsInserted > 0) {
                System.out.println("Categoria inserida com sucesso!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Falha ao inserir a categoria.");
        }
    }

    public void criaCurso() {
        String sql = "INSERT INTO cursos (nome, descricao) VALUES (?, ?)";

        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, this.nome);
            statement.setString(2, this.descricao);
            int rowsInserted = statement.executeUpdate();

            if (rowsInserted > 0) {
                System.out.println("Curso inserido com sucesso!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Falha ao inserir o curso.");
        }
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
