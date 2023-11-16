import {faker} from "@faker-js/faker";
import express from "express";

const app = express();
const port=8000;

const createUser = ()=>{
    const newUser = {

    name: faker.person.fullName(),
    gender: faker.person.fullName(),
    job: faker.person.jobTitle(),
    sex: faker.person.sexType(),
    zodiac: faker.person.zodiacSign()
};
    return newUser;
}

const createCompany = ()=>{
    const newCompany = {

    name: faker.company.name(),
    suffuces: faker.company.suffixes(),
    catchPhrase: faker.company.catchPhrase(),
    buzzPhrase: faker.company.buzzPhrase(),
    bs: faker.company.bs()
};
    return newCompany;
}

app.get("/api/users/new", (req, res)=>{
    const newUser = createUser();
    res.json(newUser);
})

app.get("/api/companies/new", (req, res)=>{
    const newCompany  = createCompany();
    res.json(newCompany)
})

app.get("/api/user/company", (req, res)=>{
    const newUser = createUser();
    const newCompany  = createCompany();
    const both ={
        user: newUser,
        company: newCompany
    }
    res.json(both)
})














app.listen(port,()=> console.log(`listening on port ${port}`));

