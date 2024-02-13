import React, { useState } from 'react';
import './App.css';

function App() {
  const [latitude, setLatitude] = useState('');
  const [longitude, setLongitude] = useState('');
  const [radius, setRadius] = useState('');
  const [places, setPlaces] = useState([]);

  const fetchPlaces = async () => {
    const response = await fetch(`http://localhost:8080/api/search?latitude=${latitude}&longitude=${longitude}&radius=${radius}`);
    const data = await response.json();
    setPlaces(data.places);
  };

  return (
    <div className="App">
      <header className="App-header">
        <h2>Yakındaki Yerleri Ara</h2>
        <input
          type="text"
          placeholder="Enlem"
          value={latitude}
          onChange={(e) => setLatitude(e.target.value)}
        />
        <input
          type="text"
          placeholder="Boylam"
          value={longitude}
          onChange={(e) => setLongitude(e.target.value)}
        />
        <input
          type="text"
          placeholder="Yarıçap (metre)"
          value={radius}
          onChange={(e) => setRadius(e.target.value)}
        />
        <button onClick={fetchPlaces}>Ara</button>

        <div>
          {places.map((place, index) => (
            <div key={index}>
              <p>{place.name}</p>
              <p>{place.address}</p>
            </div>
          ))}
        </div>
      </header>
    </div>
  );
}

export default App;
