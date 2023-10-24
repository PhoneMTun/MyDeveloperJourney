select countries.name as name, languages.language as language, languages.percentage as percenage 
from countries
join languages on countries.id=languages.country_id
where language='Slovene'
order by percentage desc;

select countries.name as name, count(cities.name) as cities
from countries
join cities on countries.id= cities.country_id
group by countries.name
order by cities desc;

SELECT  name , population, country_id FROM cities
WHERE cities.population > 500000
AND cities.country_id = ( SELECT id FROM countries WHERE countries.name = "Mexico" )
ORDER BY population DESC;

SELECT countries.name as name, languages.language as language, languages.percentage as percentage FROM countries
JOIN languages ON countries.id = languages.country_id
WHERE languages.percentage > 89
ORDER BY languages.percentage DESC;

select countries.name as name , countries.surface_area as surface_area, countries.population as population from countries
where countries.surface_area<501 and countries.population>100000;

SELECT name, government_form,capital, life_expectancy from countries
WHERE capital > 200
AND government_form ="Constitutional Monarchy"
AND life_expectancy > 75;

select countries.name as country_name, cities.name, cities. district, cities.population
from countries
join cities
on countries.id= cities.country_id
where cities. district='Buenos Aires' and cities.population>500000;

select countries.region, count(countries.name) as countries from countries
group by countries.region
order by countries desc