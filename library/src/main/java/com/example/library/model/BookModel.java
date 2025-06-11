package com.example.library.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter // Anotação do Lombok para gerar automaticamente os getters
@Setter // Anotação do Lombok para gerar automaticamente os setters
@NoArgsConstructor // Anotação do Lombok para gerar um construtor sem argumentos
@AllArgsConstructor // Anotação do Lombok para gerar um construtor com todos os argumentos
@Entity // Anotação crucial que marca esta classe como uma entidade JPA (mapeada para uma tabela no DB)
public class BookModel {

    @Id // Marca o campo 'id' como a chave primária
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Configura a geração automática do ID pelo banco de dados
    private Long id;

    private String title;
    private Integer publicationYear;

    @ManyToOne // Define o relacionamento muitos-para-um com AuthorModel
    private AuthorModel author; // O campo 'author' agora é do tipo AuthorModel
}
