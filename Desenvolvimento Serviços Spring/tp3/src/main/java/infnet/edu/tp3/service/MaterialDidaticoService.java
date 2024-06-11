package infnet.edu.tp3.service;

import infnet.edu.tp3.model.MaterialDidatico;
import infnet.edu.tp3.repository.MaterialDidaticoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MaterialDidaticoService {
    @Autowired
    private MaterialDidaticoRepository materialDidaticoRepository;

    @Cacheable(value = "materiais")
    public List<MaterialDidatico> buscarTodosMateriais() {
        return materialDidaticoRepository.findAll();
    }

    @Cacheable(value = "materiais", key = "#id")
    public Optional<MaterialDidatico> buscarMaterialDidaticoPorId(String id) {
        return materialDidaticoRepository.findById(id);
    }

    public MaterialDidatico salvarMaterialDidatico(MaterialDidatico materialDidatico) {
        return materialDidaticoRepository.save(materialDidatico);
    }

    @CacheEvict(value = "materiais", key = "#id")
    public MaterialDidatico atualizarMaterialDidatico(String id, MaterialDidatico materialDidaticoUpdate) {
        return materialDidaticoRepository.findById(id).map(materialDidatico -> {
            materialDidatico.setTitulo(materialDidaticoUpdate.getTitulo());
            materialDidatico.setConteudo(materialDidaticoUpdate.getConteudo());
            return materialDidaticoRepository.save(materialDidatico);
        }).orElseGet(() -> {
            materialDidaticoUpdate.setId(id);
            return materialDidaticoRepository.save(materialDidaticoUpdate);
        });
    }

    @CacheEvict(value = "materiais", key = "#id")
    public void deletarMaterialDidatico(String id) {
        materialDidaticoRepository.deleteById(id);
    }
}