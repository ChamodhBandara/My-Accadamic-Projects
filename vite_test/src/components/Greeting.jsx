
// src/components/Greeting.js
import React, { useState } from 'react';

function Greeting() {
  const [name, setName] = useState('');
  const [message, setMessage] = useState('');

  const handleChange = (e) => {
    setName(e.target.value);
  };

  const handleSubmit = (e) => {
    e.preventDefault();
    setMessage(`Hello ${name}, nice to meet you.`);
  };

  return (
    <div>
      <form onSubmit={handleSubmit}>
        <label>
          Enter your name:
          <input type="text" value={name} onChange={handleChange} />
        </label>
        <button type="submit">Submit</button>
      </form>
      <p>{message}</p>
    </div>
  );
}

export default Greeting;

