// import { Route, Routes } from "react-router-dom";
import "./App.css";
import { useState } from "react";

export default function App() {
  return (
    <div>
      <Create />
      <Read />
    </div>
  );
}

const Create = () => {
  const [addMovie] = useState({
    id: "",
    title: "",
    genre: "",
    date: "",
  });

  if (![addMovie]) {
    console.log("비어 있음");
  } else {
    console.log("값이 있음");
  }

  if(addMovie.id.value==){
    console.log("중복~")
  }

  return (
    <div>
      <div>
        <a href="">List</a>
        <a href="">Add New Movie</a>
      </div>

      <h1>Create Movie</h1>
      <div>
        <input placeholder="Input movie id" />
        <br />
        <input placeholder="Input movie title" />
        <br />
        <input placeholder="Input movie genre" />
        <br />
        <p>
          출시일 : <input type="date" />
        </p>
      </div>
      <button onClick={addMovie}>Add Movie</button>
    </div>
  );
};

const Read = ({ id, title, genre, release_date }) => {
  const deleteBoard = async () => {
    if (window.confirm("게시글을 삭제하시겠습니까?")) {
      await axios.delete(`//localhost:8080/board/${idx}`).then((res) => {
        alert("삭제되었습니다.");
        navigate("/Create");
      });
    }
  };
  return (
    <div>
      <div>
        <a href="">List</a>
        <a href="">Add New Movie</a>
      </div>

      <h1>Movies</h1>
      <table>
        <tr>
          <td>id</td>
          <td>title</td>
          <td>genre</td>
          <td>release_date</td>
          <td>Action</td>
        </tr>
        <tr>
          <td>{id}</td>
          <td>{title}</td>
          <td>{genre}</td>
          <td>{release_date}</td>
          <td>{Action}</td>
          <td>
            <button onClick={deleteBoard}>Delete</button>
          </td>
        </tr>
      </table>

      <div>
        <div className="card-header">
          <div onClick={onRemove}>
            <MdDelete />
          </div>
        </div>
        <div className="card-body-text"></div>
      </div>
    </div>
  );
};
