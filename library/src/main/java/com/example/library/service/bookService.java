    package com.example.library.service;

    import com.example.library.model.bookModel;
    import com.example.library.repository.bookRepository;
    import org.springframework.stereotype.Service;
    import java.util.List;

    @Service
    public class bookService {
        private final bookRepository repository;
        public bookService(bookRepository repository) {
            this.repository = repository;
        }
        public List<bookModel> findAll() { return repository.findAll(); }
        public bookModel findById(Long id) { return repository.findById(id).orElse(null); }
        public bookModel save(bookModel book) { return repository.save(book); }
        public void deleteById(Long id) { repository.deleteById(id); }
    }