    package com.example.library.repository;

    import com.example.library.model.bookModel;
    import org.springframework.data.jpa.repository.JpaRepository;

    public interface bookRepository extends JpaRepository<bookModel, Long> {}