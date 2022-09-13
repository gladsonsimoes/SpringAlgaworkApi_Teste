# SpringAlgaworkApi_Teste
Teste de API com Spring Initializr

Usando o Optinal para dar erro  no postman (404 Not Found) caso uma categoria que não exista, caso exista dará (200 OK)   

Optinal :

~~~java
 @GetMapping("/{codigo}") //endpoint get pelo codigo , {codigo} é para especificar o codigo depois /categorias
    public ResponseEntity<Categoria> buscarPeloCodigo(@PathVariable Long codigo){ //@PathVariable para buscar categoria especifica
        Optional<Categoria> categoria = categoriaRepository.findById(codigo);
        return categoria.isPresent() ? ResponseEntity.ok(categoria.get()) : ResponseEntity.notFound().build();
    }
~~~
