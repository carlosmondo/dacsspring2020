package br.univille.dacs2020.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.univille.dacs2020.model.Paciente;
import br.univille.dacs2020.services.PacienteService;

@RestController
@RequestMapping("/api/v1/paciente")
public class PacienteControllerAPI {
    @Autowired
    private PacienteService service;

    
    @GetMapping
    public ResponseEntity<List<Paciente>> getAll(){
        List<Paciente> lista = service.getAll();
        return new ResponseEntity<List<Paciente>>(lista,HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Paciente> getById(@PathVariable("id") Paciente paciente){
        if(paciente == null){
            return ResponseEntity.notFound().build();
        }
        
        return new ResponseEntity<>(paciente, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Paciente> save(@RequestBody Paciente paciente){
        service.save(paciente);
        return new ResponseEntity<Paciente>(paciente,HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Paciente> update(@PathVariable("id") Paciente pacienteAntigo, 
                                            @RequestBody Paciente pacienteAtualizado){
        if(pacienteAntigo == null){
            return ResponseEntity.notFound().build();
        }                                                                 
        pacienteAntigo.setNome(pacienteAtualizado.getNome());
        pacienteAntigo.setSexo(pacienteAtualizado.getSexo());
        pacienteAntigo.setDataNascimento(pacienteAtualizado.getDataNascimento());

        service.save(pacienteAntigo);
        return new ResponseEntity<Paciente>(pacienteAntigo,HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Paciente paciente){
        if(paciente == null){
            return ResponseEntity.notFound().build();    
        }
        service.delete(paciente);
        return ResponseEntity.ok().build();
    }
}