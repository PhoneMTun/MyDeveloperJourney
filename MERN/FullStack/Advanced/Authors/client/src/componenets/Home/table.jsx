import React from 'react';
import {Link} from 'react-router-dom';
import { Table, TableBody, TableCell, TableContainer, TableHead, TableRow, Paper, Button } from '@mui/material';
import DeleteButton from './delete';
import '../../App.css';

function AuthorsTable({authors, setAuthors}) {

    return (
        <TableContainer component={Paper} sx={{ backgroundColor: 'grey' }}>
            <Table>
                <TableHead>
                    <TableRow>
                        <TableCell>Author</TableCell>
                        <TableCell>Actions Available</TableCell>
                    </TableRow>
                </TableHead>
                <TableBody>
                    {authors.map((eachAuthor) => (
                        <TableRow key={eachAuthor._id}>
                            <TableCell>{eachAuthor.name}</TableCell>
                            <TableCell>
                                <Button variant="contained" color="primary">
                                    <Link to={`/authors/${eachAuthor._id}`} style={{ textDecoration: 'none', color: 'white' }}>Edit</Link>
                                </Button>
                                {/* <Button variant="contained" color="secondary"> */}
                                    <DeleteButton authorId={eachAuthor._id} authors={authors} setAuthors={setAuthors}/>
                                {/* </Button> */}
                            </TableCell>
                        </TableRow>
                    ))}
                </TableBody>
            </Table>
        </TableContainer>
    );
}

export default AuthorsTable;
