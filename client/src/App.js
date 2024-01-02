import React from "react";
import Header from "./components/Header";
import Footer from "./components/Footer";
import Items from "./components/Items"

class App extends React.Component {
  constructor(props){
    super(props)
    this.state = {
      items: [
        {
          id: 1,
          title: 'Кошелек c одним карманом',
          img: './',
          desc: 'Натуральная кожа1',
          category: 'кошелек',
          price: '5000'
        },
        {
          id: 2,
          title: 'Кошелек с двумя карманами',
          img: '',
          desc: 'Натуральная кожа2',
          category: 'кошелек',
          price: '6000'
        },
        {
          id: 3,
          title: 'сумка для мужчины',
          img: '',
          desc: 'Натуральная кожа3',
          category: 'сумка',
          price: '5000'
        }
      ]
    }
  }
  render() {
    return (
      <div className="wrapper">
        <Header/>
        <Items items = {this.state.items}/>
        <Footer/>
      </div>
    )
  }
}

export default App;
