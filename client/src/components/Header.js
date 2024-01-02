import React from 'react'

export default function header() {
  return (
    <header>
        <div>
            <span className='logo'>Papa Hant</span>
            <ul className='nav'>
              <li>Про нас</li>
              <li>Контакты</li>
              <li>Кабинет</li>
            </ul>
        </div>
        <div className='presentation'></div>
    </header>
  )
}
