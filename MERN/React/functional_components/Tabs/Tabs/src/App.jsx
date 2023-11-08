import { useState } from 'react';
import Tab from './components/Tabs';
import Display from './components/Display';
import './App.css';

function App() {
  const tabsArray = [
    { label: 'Tab 1', content: "Tab 1 is showing here" },
    { label: 'Tab 2', content: "Tab 2 is showing here" },
    { label: 'Tab 3', content: "Tab 3 is showing here" }
  ]

  const [allTabs, setAllTabs] = useState(tabsArray);
  const [currentTabIndex, setCurrentTabIndex] = useState(0);

  return (
    <div className='App'>
      <Tab 
        allTabs={allTabs}
        currentTabIndex={currentTabIndex}
        setCurrentTabIndex={setCurrentTabIndex}
      />
      <Display 
        allTabs={allTabs}
        currentTabIndex={currentTabIndex}
      />
    </div>
  )
}

export default App;
