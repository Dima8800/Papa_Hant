import React, { Component } from 'react'

export class item extends Component {
  render() {
    return (
      <div className='item'>
        <img scr={""}/>
        <h2>{this.props.item.title}</h2>
        <p>{this.props.item.desc}</p>
        <p>{this.props.item.price}₽</p>
        <div className='add-to-cart'>+</div>
      </div>
    )
  }
}

export default item