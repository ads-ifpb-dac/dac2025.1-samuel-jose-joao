package br.edu.ifpb.projeto.services;

import br.edu.ifpb.projeto.exceptions.ModalityNotFoundException;
import br.edu.ifpb.projeto.models.Modality;
import br.edu.ifpb.projeto.repositories.ModalityRepository;
import br.edu.ifpb.projeto.utils.GenericCRUDService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ModalityService implements GenericCRUDService<Modality> {

    private final ModalityRepository modalityRepository;

    public ModalityService(ModalityRepository modalityRepository) {
        this.modalityRepository = modalityRepository;
    }

    @Override
    public Modality findById(UUID id) {
        return this.modalityRepository.findById(id).orElseThrow(() -> new ModalityNotFoundException(id));
    }

    @Override
    public List<Modality> findAll() {
        return this.modalityRepository.findAll();
    }

    @Override
    public Modality save(Modality entity) {
        return this.modalityRepository.save(entity);
    }


    @Override
    public void delete(Modality entity) {
        this.modalityRepository.delete(entity);
    }

    @Override
    public void delete(UUID id) {
        this.modalityRepository.deleteById(id);
    }
}
