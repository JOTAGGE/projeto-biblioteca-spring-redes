    package com.example.library.service;
    
    import com.example.library.model.authorModel;
    import com.example.library.repository.authorRepository;
    import org.springframework.stereotype.Service;
    import java.util.List;
    
    @Service
    public class authorService {
        private final authorRepository repository;
        public authorService(authorRepository repository) {
            this.repository = repository;
        }
        public List<authorModel> findAll() { return repository.findAll(); }
        public authorModel findById(Long id) { return repository.findById(id).orElse(null); }
        public authorModel save(authorModel author) { return repository.save(author); }
        public void deleteById(Long id) { repository.deleteById(id); }
    }