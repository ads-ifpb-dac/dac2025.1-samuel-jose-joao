package br.edu.ifpb.projeto.services;

import br.edu.ifpb.projeto.exceptions.FieldResponseAlreadyExistsException;
import br.edu.ifpb.projeto.exceptions.FieldResponseCantBeNullException;
import br.edu.ifpb.projeto.exceptions.FieldResponseNotFoundException;
import br.edu.ifpb.projeto.models.Field;
import br.edu.ifpb.projeto.models.FieldResponse;
import br.edu.ifpb.projeto.repositories.FieldRepository;
import br.edu.ifpb.projeto.repositories.FieldResponseRepository;
import br.edu.ifpb.projeto.utils.GenericCRUDService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class FieldResponseService implements GenericCRUDService<FieldResponse> {
    private final FieldResponseRepository fieldResponseRepository;
    private final FieldRepository fieldRepository;

    public FieldResponseService(FieldResponseRepository fieldResponseRepository, FieldRepository fieldRepository) {
        this.fieldResponseRepository = fieldResponseRepository;
        this.fieldRepository = fieldRepository;
    }

    @Override
    public FieldResponse save(FieldResponse fieldResponse) {
        Field field = fieldResponse.getField();

        if(field.getIsNotNull() && fieldResponse.getContent().isEmpty()){
            throw new FieldResponseCantBeNullException(fieldResponse.getId());
        }

        if (field.getIsUnique()) {
            var responses = fieldResponseRepository.findAll();
            for (var response: responses) {
                if (response.getContent().equals(fieldResponse.getContent())) {
                    throw new FieldResponseAlreadyExistsException(fieldResponse.getId());
                }
            }
        }
        return this.fieldResponseRepository.save(fieldResponse);
    }


    @Override
    public void delete(FieldResponse entity) {

        this.fieldResponseRepository.delete(entity);
    }

    @Override
    public void delete(UUID id) {
        this.fieldResponseRepository.deleteById(id);
    }

    @Override
    public List<FieldResponse> findAll() {
        return this.fieldResponseRepository.findAll();
    }

    @Override
    public FieldResponse findById(UUID id) {
        return this.fieldResponseRepository.findById(id).orElseThrow(() -> new FieldResponseNotFoundException(id));
    }

}
