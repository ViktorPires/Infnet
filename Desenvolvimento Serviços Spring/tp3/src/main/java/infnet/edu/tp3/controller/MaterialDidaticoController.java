package infnet.edu.tp3.controller;

import infnet.edu.tp3.model.MaterialDidatico;
import infnet.edu.tp3.service.MaterialDidaticoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/materiais")
public class MaterialDidaticoController {
    @Autowired
    private MaterialDidaticoService materialDidaticoService;

    @GetMapping
    public List<MaterialDidatico> getAllMateriais() {
        return materialDidaticoService.buscarTodosMateriais();
    }

    @GetMapping("/{id}")
    public MaterialDidatico getMaterialDidaticoPorId(@PathVariable String id) {
        return materialDidaticoService.buscarMaterialDidaticoPorId(id)
                .orElseThrow(() -> new RuntimeException("Material não encontrado com o id: " + id));
    }

    @PostMapping
    public MaterialDidatico createMaterialDidatico(@RequestBody MaterialDidatico materialDidatico) {
        return materialDidaticoService.salvarMaterialDidatico(materialDidatico);
    }

    @PutMapping("/{id}")
    public MaterialDidatico updateMaterialDidatico(@PathVariable String id, @RequestBody MaterialDidatico materialDidaticoUpdate) {
        return materialDidaticoService.atualizarMaterialDidatico(id, materialDidaticoUpdate);
    }

    @DeleteMapping("/{id}")
    public void deleteMaterialDidatico(@PathVariable String id) {
        materialDidaticoService.deletarMaterialDidatico(id);
    }
}
