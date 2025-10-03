import './App.css'
import './index.css'
import { useTokenRefresher } from './shared/hooks/TokenRefresher';

function App() {
  useTokenRefresher();
  return (
    <div className="App">
      <h1 className="text-3xl font-bold text-blue-600">
        Tailwind OK
      </h1>
    </div>
  )
}

export default App
