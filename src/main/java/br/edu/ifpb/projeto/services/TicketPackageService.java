package br.edu.ifpb.projeto.services;

import br.edu.ifpb.projeto.exceptions.TicketPackageNotFoundException;
import br.edu.ifpb.projeto.models.TicketPackage;
import br.edu.ifpb.projeto.repositories.TicketPackageRepository;
import br.edu.ifpb.projeto.utils.GenericCRUDService;
import org.hibernate.ObjectNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class TicketPackageService implements GenericCRUDService<TicketPackage> {

    private final TicketPackageRepository repository;

    public TicketPackageService(TicketPackageRepository repository) {
        this.repository = repository;
    }

    @Override
    public TicketPackage findById(UUID id) {
        return this.repository.findById(id).orElseThrow(() -> new TicketPackageNotFoundException(id));
    }

    @Override
    public List<TicketPackage> findAll() {
        return this.repository.findAll();
    }

    @Override
    public TicketPackage save(TicketPackage entity) {
        return this.repository.save(entity);
    }

    @Override
    public void delete(TicketPackage entity) {
        this.repository.delete(entity);
    }

    @Override
    public void delete(UUID id) {
        this.repository.deleteById(id);
    }
}
