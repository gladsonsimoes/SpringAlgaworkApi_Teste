# SpringAlgaworkApi_Teste
Teste de API com Spring Initializr

Usando o Optinal no JAVA para verificar categoria no banco de dados , caso a categoria não exista aparecerá (404 Not Found) , caso exista dará (200 OK)   

Optinal:

~~~java
 @GetMapping("/{codigo}") //endpoint get pelo codigo , {codigo} é para especificar o codigo depois /categorias
    public ResponseEntity<Categoria> buscarPeloCodigo(@PathVariable Long codigo){ //@PathVariable para buscar categoria especifica
        Optional<Categoria> categoria = categoriaRepository.findById(codigo);
        return categoria.isPresent() ? ResponseEntity.ok(categoria.get()) : ResponseEntity.notFound().build();
    }
~~~

em aplication.propreties 

~~~java
spring.jackson.deserialization.fail-on-unknown-properties=true 
~~~
esse comando acima é para informar um erro caso coloque mais de uma atributo no JSON no postman que não está indetificado no CategoriaResource

em pom.xml
~~~xml
		<dependency>  <!-- excessao  -->
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-validation</artifactId>
		</dependency>

		<!-- mysql -->
		<dependency>
			<groupId>mysql</groupId>
			<artifactId>mysql-connector-java</artifactId>
			<scope>runtime</scope>
		</dependency>
~~~

Pois no metodo passado sem essa verificação no banco de dados aparecerá como 200 OK mesmo que a categoria não exista

Sem Optinal:

~~~java
 @GetMapping("/{codigo}") //endpoint get pelo codigo , {codigo} é para especificar o codigo depois /categorias
    public Categoria buscarPeloCodigo(@PathVariable Long codigo){ //@PathVariable para buscar categoria especifica
        return categoriaRepository.findById(codigo).orElse(null);
    }
~~~
