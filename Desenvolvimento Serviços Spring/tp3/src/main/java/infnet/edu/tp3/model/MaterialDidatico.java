package infnet.edu.tp3.model;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "materialDidatico")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MaterialDidatico {
    @Id
    private String id;
    private String titulo;
    private String conteudo;
}
