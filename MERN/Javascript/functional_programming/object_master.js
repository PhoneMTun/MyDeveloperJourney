const pokémon = Object.freeze([
        { "id": 1,   "name": "Bulbasaur",  "types": ["poison", "grass"] },
        { "id": 5,   "name": "Charmeleon", "types": ["fire"] },
        { "id": 9,   "name": "Blastoise",  "types": ["water"] },
        { "id": 12,  "name": "Butterfree", "types": ["bug", "flying"] },
        { "id": 16,  "name": "Pidgey",     "types": ["normal", "flying"] },
        { "id": 23,  "name": "Ekans",      "types": ["poison"] },
        { "id": 24,  "name": "Arbok",      "types": ["poison"] },
        { "id": 25,  "name": "Pikachu",    "types": ["electric"] },
        { "id": 37,  "name": "Vulpix",     "types": ["fire"] },
        { "id": 52,  "name": "Meowth",     "types": ["normal"] },
        { "id": 63,  "name": "Abra",       "types": ["psychic"] },
        { "id": 67,  "name": "Machamp",    "types": ["fighting"] },
        { "id": 72,  "name": "Tentacool",  "types": ["water", "poison"] },
        { "id": 74,  "name": "Geodude",    "types": ["rock", "ground"] },
        { "id": 87,  "name": "Dewgong",    "types": ["water", "ice"] },
        { "id": 98,  "name": "Krabby",     "types": ["water"] },
        { "id": 115, "name": "Kangaskhan", "types": ["normal"] },
        { "id": 122, "name": "Mr. Mime",   "types": ["psychic"] },
        { "id": 133, "name": "Eevee",      "types": ["normal"] },
        { "id": 144, "name": "Articuno",   "types": ["ice", "flying"] },
        { "id": 145, "name": "Zapdos",     "types": ["electric", "flying"] },
        { "id": 146, "name": "Moltres",    "types": ["fire", "flying"] },
        { "id": 148, "name": "Dragonair",  "types": ["dragon"] }
    ]);
    

    // Array of pokemon where id is evenly divisible by 3

    // const divible3 = pokémon.filter(val=>val.id%3===0);
    // console.log(divible3);

    // An array of pokemon objects that are "fire" types that

    // const firetypes = pokémon.filter(val=> val.types=="fire");
    // console.log(firetypes);

    // An array of pokemon objects that have more than one type

    // const morethanonetypes = pokémon.filter(val=> val.types.length>1);
    // console.log(morethanonetypes);

    // An array with jast the bames of the pokemmons that

    // const justnames= pokémon.map(val=>val.name);
    // console.log(justnames)

    // An array with just then name of pokemon with an id greater than 99
    // const justnamesid= pokémon.filter(val=>val.id>99).map(val=> val.name);
    // console.log(justnamesid)

    // An array with just than names of the pokemoin whose only type si poison
    // const justpoision= pokémon.filter(val=> val.types[0]==='poison'&&val.types.length===1).map(val=>val.name)
    // console.log(justpoision)

    // An array containgn just the first type of all the pokemon whose second type is flying
    // const secondflying= pokémon.filter(val=>val.types[1]==='flying').map(val => val.types[0]);
    // console.log(secondflying);

    // a count of the number of pokémon that are "normal" type
    // const countnormaltype= pokémon.filter(val=>val.types.includes('normal')).length;
    // console.log(countnormaltype);