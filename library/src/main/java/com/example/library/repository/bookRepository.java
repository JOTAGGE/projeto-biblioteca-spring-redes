    package com.example.library.repository;

    import com.example.library.model.BookModel;
    import org.springframework.data.jpa.repository.JpaRepository;

    public interface bookRepository extends JpaRepository<BookModel, Long> {}