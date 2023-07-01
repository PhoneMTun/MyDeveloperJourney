console.log("hello");

async function getpokemons() {

    for (let i = 1; i <= 1010; i++) {
        let response = await fetch(`https://pokeapi.co/api/v2/pokemon/${i}`);
        let pokemon = await response.json();
        var mypokemon= {
            ID: pokemon.id,
            Name: pokemon.name,
            Element: pokemon.types.map(type=> type.type.name).join(", "),
            Image: pokemon.sprites['front_default']
        };
        console.log(mypokemon);

    }
}

getpokemons();


// function pokemons(name, id, type)s