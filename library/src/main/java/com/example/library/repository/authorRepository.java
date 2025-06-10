    package com.example.library.repository;

    import com.example.library.model.AuthorModel;
    import org.springframework.data.jpa.repository.JpaRepository;

    public interface authorRepository extends JpaRepository<AuthorModel, Long> {}