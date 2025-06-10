    package com.example.library.repository;

    import com.example.library.model.authorModel;
    import org.springframework.data.jpa.repository.JpaRepository;

    public interface authorRepository extends JpaRepository<authorModel, Long> {}