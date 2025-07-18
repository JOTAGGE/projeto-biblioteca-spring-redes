    package com.example.library.service;
    
    import com.example.library.model.AuthorModel;
    import com.example.library.repository.AuthorRepository;
    import org.springframework.stereotype.Service;
    import java.util.List;
    
    @Service
    public class AuthorService {
        private final AuthorRepository repository;
        public AuthorService(AuthorRepository repository) {
            this.repository = repository;
        }
        public List<AuthorModel> findAll() { return repository.findAll(); }
        public AuthorModel findById(Long id) { return repository.findById(id).orElse(null); }
        public AuthorModel save(AuthorModel author) { return repository.save(author); }
        public void deleteById(Long id) { repository.deleteById(id); }
    }