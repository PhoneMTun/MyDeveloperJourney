import './App.css'
import PersonCard from './components/PersonCard'

function App() {
  
  return (
    <div>
        <PersonCard firstName="John" lastName="Doe" age={28} hairColor="Brown" />
        <PersonCard firstName="Phone" lastName="Tun" age={23} hairColor="Black" />
        <PersonCard firstName="Sean" lastName="Linn" age={32} hairColor="Golden" />
        <PersonCard firstName="Kevin" lastName="Ramada" age={30} hairColor="Black" />
    </div>
  )
}

export default App;
