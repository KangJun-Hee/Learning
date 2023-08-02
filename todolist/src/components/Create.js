import React,{useState} from "react";
import styled,{css} from 'styled-components';
import {MdAdd} from 'react-icons/md';
import { useDispatch,useNextId } from "../Context";


function Create(){
    const [open,setOpen] = useState(false);
    const [value,setValue] = useState("");
    const dispatch = useDispatch();
    const nextId = useNextId();

    const onToggle = () => setOpen(!open);
    const handleChange = e => setValue(e.target.value);
    const handleSubmit = e => {
        e.preventDefault();
        dispatch({
            type:'CREATE',
            todo:{
                id:nextId.current,
                text:value,
                done:false
            }
        });
        nextId.current += 1;
        setOpen(false);
        setValue('');
    };

    return(
        <>
            {open &&(
                <div>
                    <form onSubmit={handleSubmit}>
                        <input
                            value={value}
                            onChange={handleChange}
                            placeholder="앞으로 할 일 계획"
                        />    
                    </form>
                </div>
            )}
                    <button onClick={onToggle} open={open}>
                        <MdAdd/>
                    </button>
        </>
    );
}

export default Create;