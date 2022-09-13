# SpringAlgaworkApi_Teste
Teste de API com Spring Initializr

Usando o Optinal no JAVA para verificar categoria no banco de dados , caso a categoria não exista aparecerá (404 Not Found) , caso exista dará (200 OK)   

Optinal :

~~~java
 @GetMapping("/{codigo}") //endpoint get pelo codigo , {codigo} é para especificar o codigo depois /categorias
    public ResponseEntity<Categoria> buscarPeloCodigo(@PathVariable Long codigo){ //@PathVariable para buscar categoria especifica
        Optional<Categoria> categoria = categoriaRepository.findById(codigo);
        return categoria.isPresent() ? ResponseEntity.ok(categoria.get()) : ResponseEntity.notFound().build();
    }
~~~
