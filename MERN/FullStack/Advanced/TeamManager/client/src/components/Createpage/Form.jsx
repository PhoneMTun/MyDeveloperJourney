import React, { useState } from 'react';
import { Container, Box, TextField, Button } from '@mui/material';
import {Link} from 'react-router-dom'

export default function Form({ submithandler, errors, handleChange, formData}) {

    return (
        <div>
            <h2><Link to = {"/"} >List</Link> | <Link to = {"/players/addplayer"} className='underline-link '>Add Player</Link></h2>
            <Container maxWidth="sm">
                <Box component="form" onSubmit={submithandler} noValidate sx={{ mt: 1 }}>
                    <TextField
                        required
                        fullWidth
                        id="name"
                        label="Name"
                        name="name"
                        margin="normal"
                        value={formData.name}
                        onChange={handleChange}
                        error={Boolean(errors.name)}
                        helperText={errors.name}
                        sx={{
                            '& label.Mui-focused': {
                                color: 'white',
                            },
                            '& .MuiInput-underline:after': {
                                borderBottomColor: 'white',
                            },
                            '& .MuiOutlinedInput-root': {
                                '& fieldset': {
                                    borderColor: 'white',
                                },
                                '&:hover fieldset': {
                                    borderColor: 'white',
                                },
                                '&.Mui-focused fieldset': {
                                    borderColor: 'white',
                                },
                            },
                            input: {
                                color: 'white',
                            }
                        }}
                        InputLabelProps={{
                            style: { color: 'white' },
                        }}
                    />
                    <TextField
                        required
                        fullWidth
                        id="position"
                        label="Position"
                        name="position"
                        margin="normal"
                        value={formData.position}
                        onChange={handleChange}
                        error={Boolean(errors.position)}
                        helperText={errors.position}
                        sx={{
                            '& label.Mui-focused': {
                                color: 'white',
                            },
                            '& .MuiInput-underline:after': {
                                borderBottomColor: 'white',
                            },
                            '& .MuiOutlinedInput-root': {
                                '& fieldset': {
                                    borderColor: 'white',
                                },
                                '&:hover fieldset': {
                                    borderColor: 'white',
                                },
                                '&.Mui-focused fieldset': {
                                    borderColor: 'white',
                                },
                            },
                            input: {
                                color: 'white',
                            }
                        }}
                        InputLabelProps={{
                            style: { color: 'white' },
                        }}
                    />
                    <Button 
                        type="submit" 
                        fullWidth 
                        variant="contained" 
                        sx={{ mt: 3, mb: 2 }}
                    >
                        Submit
                    </Button>
                </Box>
            </Container>
        </div>
    );
}
