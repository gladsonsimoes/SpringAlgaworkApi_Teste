package com.example.algamoney.api.resource;

import com.example.algamoney.api.model.Categoria;
import com.example.algamoney.api.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletResponse;
import java.net.URI;
import java.util.List;
import java.util.Optional;

//implementar os metodos
@RestController
@RequestMapping("/categorias")
public class CategoriaResource {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @GetMapping //endpoint Get
    public List<Categoria> listar(){ //retorna a lista de categoria
        return categoriaRepository.findAll();
    }
    @PostMapping //endpoint post
    public ResponseEntity<Categoria> criar(@RequestBody Categoria categoria , HttpServletResponse response){ //retorna apenas a categoria
        Categoria categoriaSalva = categoriaRepository.save(categoria);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{codigo}") //para criar a url para o postman
                .buildAndExpand(categoriaSalva.getCodigo()).toUri(); //getcodigo para ver o somente o codigo
        response.setHeader("Location", uri.toASCIIString());
        return ResponseEntity.created(uri).body(categoriaSalva);
    }
    @GetMapping("/{codigo}") //endpoint get pelo codigo , {codigo} é para especificar o codigo depois /categorias
    public ResponseEntity<Categoria> buscarPeloCodigo(@PathVariable Long codigo){ //@PathVariable para buscar categoria especifica
        Optional<Categoria> categoria = categoriaRepository.findById(codigo);
        return categoria.isPresent() ? ResponseEntity.ok(categoria.get()) : ResponseEntity.notFound().build();
    }

}
