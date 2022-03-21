package br.com.registro.controller.registro;

import br.com.registro.model.dto.RegistroRequest;
import br.com.registro.model.dto.RegistroResponse;
import br.com.registro.model.service.RegistroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/registros")
public class RegistroController {

    @Autowired
    private RegistroService registroService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<RegistroResponse> findAll(){
        return this.registroService.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void adicionarRegistro(@RequestBody RegistroRequest registroRequest){
        this.registroService.adicionarRegistro(registroRequest);
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.OK)
    public void deletarRegistro(@RequestParam Long id){
        this.registroService.deletarRegistro(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void atualizarRegistro(@PathVariable Long id, @RequestBody RegistroRequest registroRequest){
        this.registroService.atualizarRegistro(id, registroRequest);
    }



}
