import './App.css'
import PersonCard from './components/PersonCard.jsx';

function App() {

  return (
    <>
      <div className='App'>
        <PersonCard
        fname={"Jane"}
        lname={"Doe"}
        age={"45"}
        hcolor={"Black"}
      />
      <PersonCard
        fname={"John"}
        lname={"Smith"}
        age={"88"}
        hcolor={"Brown"}
      />
      <PersonCard
        fname={"Millard"}
        lname={"Fillmore"}
        age={"50"}
        hcolor={"Brown"}
      />
      <PersonCard
        fname={"Maria"}
        lname={"Smith"}
        age={"62"}
        hcolor={"Brown"}
      />
      
        </div>
    </>
  )
}

export default App
